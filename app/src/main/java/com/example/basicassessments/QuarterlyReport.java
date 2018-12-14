package com.example.basicassessments;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;


import java.util.ArrayList;

public class QuarterlyReport {
    private ArrayList<Assessment> assessments;

    private int highestCount;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void generateReport()
    {

        String missed;

        for (Assessment a: assessments) {
            a.refreshAssessmentList();
            missed = a.getQuestions().get(0).getSubject() + " Questions Missed:\n";


            for (Question q : a.getMissedList()) {
                missed += q.getIdentity() + "\n";
            }

            missed += "\n";

            }
            // create a new document
            PdfDocument document = new PdfDocument();

            // crate a page description
            PdfDocument.PageInfo pageInfo =
                    new PdfDocument.PageInfo.Builder(100, 100, 1).create();

            // start a page
            PdfDocument.Page page = document.startPage(pageInfo);

            Canvas canvas = page.getCanvas();

            Paint paint = new Paint();
            paint.setColor(Color.BLACK);


//TODO finish this!






        }
    }

