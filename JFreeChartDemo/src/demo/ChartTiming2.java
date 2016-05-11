// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;

// Referenced classes of package demo:
//			SampleXYDataset2

public class ChartTiming2
	implements ActionListener
{

	private boolean finished;

	public ChartTiming2()
	{
	}

	public void run()
	{
		finished = false;
		SampleXYDataset2 samplexydataset2 = new SampleXYDataset2(1, 1440);
		boolean flag = true;
		JFreeChart jfreechart = ChartFactory.createScatterPlot("Scatter plot timing", "X", "Y", samplexydataset2, PlotOrientation.VERTICAL, flag, false, false);
		XYPlot xyplot = (XYPlot)jfreechart.getPlot();
		xyplot.setRenderer(new XYDotRenderer());
		BufferedImage bufferedimage = new BufferedImage(400, 300, 1);
		java.awt.Graphics2D graphics2d = bufferedimage.createGraphics();
		java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, 400D, 300D);
		Timer timer = new Timer(10000, this);
		timer.setRepeats(false);
		int i = 0;
		timer.start();
		do
		{
			if (finished)
				break;
			jfreechart.draw(graphics2d, double1, null, null);
			System.out.println("Charts drawn..." + i);
			if (!finished)
				i++;
		} while (true);
		System.out.println("DONE");
	}

	public void actionPerformed(ActionEvent actionevent)
	{
		finished = true;
	}

	public static void main(String args[])
	{
		ChartTiming2 charttiming2 = new ChartTiming2();
		charttiming2.run();
	}
}
