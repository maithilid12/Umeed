package com.example.shreyaghose.umeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Graph extends AppCompatActivity {
    float values[]={20f,53f,12f,5f,10f};
    String reasons[]={"Family","Alcohol consumption","Financial","Education","Other"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        setupPieChart();
    }

    private void setupPieChart() {
        List<PieEntry> pieEntries=new ArrayList<>();
        for(int i=0;i<values.length;i++) {
            pieEntries.add(new PieEntry(values[i], reasons[i]));

        }
        PieDataSet dataset=new PieDataSet(pieEntries,"CAUSES FOR DEPRESSION OR ANXIETY");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data=new PieData(dataset);
        PieChart chart=(PieChart)findViewById(R.id.chart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();

    }
    }

