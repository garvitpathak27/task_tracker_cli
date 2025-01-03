Project url : https://roadmap.sh/projects/task-tracker

Here's how to directly access the settings.json file for your workspace:
Open Command Palette: Press Ctrl+Shift+P (Windows/Linux) or Cmd+Shift+P (Mac) to open the Command Palette.

Search for settings.json: Type Preferences: Open Workspace Settings (JSON) in the Command Palette and select it. This should open the raw settings.json file where you can manually add the classpath.

Modify the settings.json: In the settings.json file that opens, look for a section like this:

json
Copy code
{
  "java.project.referencedLibraries": [
    "libs/json-20210307.jar"
  ]
}
If this section doesn’t exist, you can add it manually. If it's there, just make sure the path to the JAR file is correct, relative to your project structure.



javac -cp .:libs/json-20210307.jar src/tasktracker/*.java

java -cp out:libs/json-20210307.jar tasktracker.Main 

