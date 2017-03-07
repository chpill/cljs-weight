#!/bin/bash


pushd target/js;

buildsBySize=`ls -sShr | grep "\.js" | awk '{print$2}'`

echo build JS GZIP | awk '{printf("| %-25s | %4s | %4s |\n", $1, $2, $3);}'
echo "|---------------------------|------|------|"

paste \
    <(echo "$buildsBySize") \
    <(echo "$buildsBySize" | parallel wc -c | awk '{print$1}' | parallel -j1 node ../../scripts/pp-size.js) \
    <(echo "$buildsBySize" | parallel 'gzip -c {} | wc -c ' | parallel -j1 node ../../scripts/pp-size.js) |\
    awk '{printf("| %-25s | %4s | %4s |\n", $1, $2, $3);}';

popd;
