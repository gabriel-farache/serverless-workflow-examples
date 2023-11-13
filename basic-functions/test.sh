#!/bin/bash
#

 curl \
  -X DELETE \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: token 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" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/eloycoto/dotfiles/git/refs/heads/test

curl \
    -H 'Content-Type:application/json' \
    -H 'Accept:application/json' \
    "http://localhost:8080/BasicExample" \
    -d '{"github_token": "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", "sha": "c4c7f4c46fff1ef11cd46ce6782f4bcbecdbf1b9", "branch": "test", "base_branch": "master","org": "eloycoto", "repo": "dotfiles" }' -v