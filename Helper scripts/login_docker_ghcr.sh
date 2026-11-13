#!/usr/bin/bash

set -e

if [ "$#" -ne 2 ]; then
    echo "Missing arguments"
    echo ""
    echo "- Usage: $0 <GitHub Access Token for GHCR> <Username>"
    echo "- Example: $0 ghp_123451234512345123451234512345 davinci-sixnine"
    exit 1
fi

GHCR_TOKEN="$1"
USERNAME="$2"

echo "Logging into GHCR for: '$USERNAME'"

echo "$GHCR_TOKEN" | docker login ghcr.io -u "$USERNAME" --password-stdin