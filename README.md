# AutoArchivingTool

A Maven project. Simple software that allows the user to copy and paste folders at command or scheduling the actions 
to run automatically at specified times.

This software allows the user to copy and paste files/folders from a path to another which are contained in the Excel file named "AutoArchivingPaths_ToBeSetManually.xlsx". Please do not change name/extension of it. Simply substitute the paths in column A and C, the file is already populated with an example. All formulas can be used as the file is automatically saved using a .vbs file (avoiding the issue of using not accepted formulas that you may encounter when using XSSFFormulaEvaluator.evaluateAllFormulaCells(xssfWorkbook) or similar solutions). The software allows also to perform a check of the directories. The SizeCheck() method will compare the size of the folder/file in column A to the folder/file at path in column C, and will return the output in SizeCheckOutput.txt listing the inconsistencies.

You can download the project an import it as an existing Maven project or if you just want to use the program you can run the .jar simply by double clicking it, note that you will still need the other files to be in the same folder where the .jar is located as all the paths are based on the location of it.


