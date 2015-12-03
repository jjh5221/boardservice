# boardservice

Sub transPDF()
On Error GoTo errorCheck
    
    Dim startIndex As Integer
    Dim endIndex As Integer
    Dim mydir As String
    Dim sChkFile As String
    
    mydir = ThisWorkbook.Path & "\PDF\"
    
    startIndex = Range("O6").Value
    endIndex = Range("Q6").Value
    
    If endIndex < startIndex Then
        If endIndex = 0 Then
            endIndex = startIndex
        Else
            MsgBox ("범위확인")
        End If
    End If
    For i = startIndex To endIndex Step 1
        Range("O2").Value = i
        insertImage (i)
        Call arrangeImageToCenter
        ActiveSheet.ExportAsFixedFormat Type:=xlTypePDF, fileName:=mydir & i & "_" & Range("E7").Value & "_용천수 조사대장.PDF"
    Next
errorCheck:
    If Err.Number <> 0 Then
        MsgBox "오류번호 : " & Err.Number & vbCr & _
        "오류내용 : " & Err.Description, vbCritical, "오류"
    End If
End Sub
Sub openFile()
    Dim strAdr As String
    Dim strFile As String
    Dim nogada As String
    
    strAdr = Application.GetOpenFilename(Title:=" 파일을 선택하세요//파일선택")
    fileName = Dir(strAdr)
    
    nogada (fileName)
    
    If strAdr = "False" Then
        MsgBox "아무 파일도 선택되지 않았습니다", 64, "선택오류"
        Exit Sub
    End If
End Sub
Function insertImage(springWaterNum As Integer)
    Sheets("Sheet1").Pictures.Delete
    
    For i = 1 To 4 Step 1
        Call shapeImage(springWaterNum, i)
    Next
End Function

Function shapeImage(springWaterNum, i)
    Dim strFile As String
    Application.ScreenUpdating = False
    Dim imageCell As String
    Dim sChkFile As String
    
    strFile = ThisWorkbook.Path & "\image\" & springWaterNum & "\" & springWaterNum & "-" & i & ".jpg"
    imageCell = "image" & i
    
    sChkFile = Len(Dir(strFile))
    If sChkFile > 0 Then            '파일이 있는지 체크
        Range(imageCell).Select
    
        With ActiveSheet.Pictures.Insert(strFile).ShapeRange
            '.LockAspectRatio = msoFalse '엑셀 좌우고정비율 해제
            .Top = Range(imageCell).Top + 1
            .Left = Range(imageCell).Left + 1
            .Width = 260
        End With
    Else
    
    End If
End Function

Function arrangeImageToCenter()
    Dim s As Shape, r As Range
    Dim ws As Worksheet: Set ws = ActiveSheet
    For Each s In ws.Shapes
        Set r = s.TopLeftCell

         If s.Height < 200 And s.Height > 100 Then
            If s.Top < Range("A63").Top Then
                s.Top = Range("a47").Top
            Else
                s.Top = Range("A68").Top
            End If
        End If
    Next s
End Function

Function nogada(fileName As String)
    Dim myCells() As String
    
    myCells(0) = "E4"
    myCells(1) = "E6"
    myCells(2) = "E7"
    myCells(3) = "E8"
    myCells(4) = "E9"
    myCells(5) = "E10"
    myCells(6) = "E11"
    myCells(7) = "E12"
    myCells(8) = "E15"
    myCells(9) = "E16"
    myCells(10) = "E18"
    myCells(11) = "E20"
    myCells(12) = "E22"
    myCells(13) = "E24"
    myCells(14) = "E26"
    myCells(15) = "E27"
    myCells(16) = "E28"
    myCells(17) = "E29"
    myCells(18) = "E30"
    myCells(19) = "L4"
    myCells(20) = "L6"
    myCells(21) = "L8"
    myCells(22) = "L10"
    myCells(23) = "L12"
    myCells(24) = "L14"
    myCells(25) = "L15"
    myCells(26) = "L16"
    myCells(27) = "L17"
    myCells(28) = "L18"
    myCells(29) = "L20"
    myCells(30) = "L21"
    myCells(31) = "L22"
    myCells(32) = "L23"
    myCells(33) = "L24"
    myCells(34) = "L26"
    myCells(35) = "L27"
    myCells(36) = "L28"
    myCells(37) = "L29"
    myCells(38) = "L30"
    myCells(39) = "L31"
    myCells(40) = "B32"
    myCells(41) = "C38"
    myCells(42) = "G38"
    myCells(43) = "B39"
    
    
    
End Function

