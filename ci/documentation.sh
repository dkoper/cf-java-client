#!/usr/bin/env bash

set -e

PROJECTS=" \
  cloudfoundry-client \
  cloudfoundry-client-reactor \
  cloudfoundry-operations \
  cloudfoundry-util"

git clone cf-java-client-documentation updated-cf-java-client-documentation

pushd cf-java-client
  ./mvnw -q -Dmaven.test.skip=true package
  VERSION=$(./mvnw help:evaluate -Dexpression=project.version | grep -v '\[' | grep -v 'Download')
popd

for PROJECT in $PROJECTS ; do
  SOURCE=cf-java-client/$PROJECT/target/apidocs
  TARGET=updated-cf-java-client-documentation/api/$VERSION/$PROJECT

  if [[ -e $SOURCE ]]; then
    echo Copying $SOURCE to $TARGET

    mkdir -p $TARGET
    rm -rf $TARGET/*
    cp -r $SOURCE/* $TARGET

    for FILE in $(find $TARGET -type f); do
      sed -i '/Generated by javadoc/d' $FILE
      sed -i '/meta name="date"/d' $FILE
    done
  fi
done

pushd updated-cf-java-client-documentation
  git config --local user.name "Spring Buildmaster"
  git config --local user.email "buildmaster@springframework.org"
  git add .

  if ! git diff-index --cached --quiet HEAD --ignore-submodules --; then
    git commit --message "$VERSION Documentation Update"
  fi
popd
