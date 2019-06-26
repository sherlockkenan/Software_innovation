REPORTER ?= spec

test:
	mocha \
    --reporter $(REPORTER) \
    test/*.js \
    
bump: ;node ./bumpVersion.js

version: test bump

publish: ;npm publish
pub: test bump publish
.PHONY: test bump pub