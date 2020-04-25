# AutoArchivingTool

A Maven project including pom.xml and the executable .jar program with dependencies included. Simple software that allows the user to copy and paste folders at command or scheduling the actions 
to run automatically at specified times.

This software allows the user to copy and paste files/folders from a path to another which are contained in the Excel file named "AutoArchivingPaths_ToBeSetManually.xlsx". Please do not change name/extension of it. Simply substitute the paths in column A and C, the file is already populated with an example. Formulas can be used as the file is automatically saved using a .vbs file (avoiding the issue of using not accepted formulas that you may encounter when using XSSFFormulaEvaluator.evaluateAllFormulaCells(xssfWorkbook) or similar solutions). Destination directory will be created if missing. The software allows also to perform a check of the directories to see if everything was copied succesfully. The SizeCheck() method will compare the size of the folder/file in column A to the folder/file at path in column C, and will return the output in SizeCheckOutput.txt listing the inconsistencies.

If you want to definetly close the program please click on the button "Exit". If you click on the top-right corner for closing the window the program will be minimized to a trayicon which is ideal if you have set the tasks to be performed automatically at a specified time(e.g. if you set the archiving to run at 7pm every day you will need to keep program running in background and so you will not have to close the tryicon).

You can download the project and import it as an existing Maven project or if you just want to use the program you can run the .jar simply by double clicking it. Note that you will need all the files to be in the same folder where the .jar is located as all the paths are based on the location of it. You will also need JDK installed on your machine (compiled using version 1.8)

Ideas for future development includes variable time periods for automated running (currently can only set to run at specified time every 24h), improve GUI, improve user-program interaction. These were not realized because of time constraints and because the milestones looked for were achieved. 
