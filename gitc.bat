@echo off
git add .
set /p id="Enter commit name: "
git commit -m "%id%"
git push