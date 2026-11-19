
#!/bin/bash

echo "Checking Git status..."
git status

echo "Adding project files..."
git add .

echo "Committing changes..."
git commit -m "Update Spring Boot Student Project"

echo "Pulling latest GitHub changes..."
git pull origin main --allow-unrelated-histories

echo "Pushing project to GitHub..."
git push -u origin main

echo "Git operation completed!"
