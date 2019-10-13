Option Explicit

Dim objExcel1, objWB, strPathExcel1, objSheet1, objSheet2, sCurPath, sCurPath2


sCurPath = CreateObject("Scripting.FileSystemObject").GetAbsolutePathName(".") 
sCurPath2 = sCurPath
sCurPath=sCurPath & "\AutoArchivingPaths_ToBeSetManually.xlsx"
'msgbox sCurPath



Set objExcel1 = CreateObject("Excel.Application") 'Object for Condition Dump
strPathExcel1 = sCurPath
Set objWB = objExcel1.Workbooks.Open(strPathExcel1)
Set objSheet1 = objWB.Worksheets(1)
Set objSheet2 = objWB.Worksheets(2)



objWB.SaveAs(sCurPath2 & "\AutoArchivingPaths.xlsx")
'objWB.Save
objWB.Close
objExcel1.Quit


'~~> Cleanup
Set objSheet1 = Nothing
Set objSheet2 = Nothing
Set objWB = Nothing
Set objExcel1 = Nothing
'======================