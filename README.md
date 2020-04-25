# AutoArchivingTool

I know there is a method which is kind of reundant, this was just my first full Java application I did not care about details. A Maven project including pom.xml and the executable .jar program with dependencies included. Simple software that allows the user to copy and paste folders at command or scheduling the actions 
to run automatically at specified times.

This software allows the user to copy and paste files/folders from a path to another which are contained in the Excel file named "AutoArchivingPaths_ToBeSetManually.xlsx". Please do not change name/extension of it. Simply substitute the paths in column A and C, the file is already populated with an example. All formulas can be used as the file is automatically saved using a .vbs file (avoiding the issue of using not accepted formulas that you may encounter when using XSSFFormulaEvaluator.evaluateAllFormulaCells(xssfWorkbook) or similar solutions). The software allows also to perform a check of the directories. The SizeCheck() method will compare the size of the folder/file in column A to the folder/file at path in column C, and will return the output in SizeCheckOutput.txt listing the inconsistencies.

If you want to definetly close the programe please click on the button "Exit". If you click on the top-right corner for closing the window the program will be minimized to a trayicon which is ideal if you have set the tasks to be performed automatically at a specified time.

You can download the project and import it as an existing Maven project or if you just want to use the program you can run the .jar simply by double clicking it. Note that you will need all the files to be in the same folder where the .jar is located as all the paths are based on the location of it. You will also need JDK installed on your machine (version 8u251)
