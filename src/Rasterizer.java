/*
 * Rasterizer.java
 * 
 * Version: $Id: Rasterizer.java, v 1.1 2015/06/03 16:14:43
 * 
 * Revisions: 
 * 
 * Initial Revision
 * 
 */

/**
 * 
 * A simple class for performing rasterization algorithms.
 *
 * @author Sanika Kulkarni
 *
 */

import java.util.*;

public class Rasterizer {
	/**
	 * number of scanlines
	 */
	int numberOfScanLines;

	/**
	 * Constructor
	 *
	 * @param n
	 *            number of scanlines
	 *
	 */
	Rasterizer(int n) {
		numberOfScanLines = n;
	}

	// initializing array lists
	ArrayList<BucketOfEdges> arrList = new ArrayList<BucketOfEdges>();

	ArrayList<BucketOfEdges> buckets = new ArrayList<BucketOfEdges>();

	/**
	 * Draw a filled polygon in the simpleCanvas C.
	 *
	 * The polygon has n distinct vertices. The coordinates of the vertices
	 * making up the polygon are stored in the x and y arrays. The ith vertex
	 * will have coordinate (x[i], y[i])
	 *
	 * You are to add the implementation here using only calls to C.setPixel()
	 */
	public void drawPolygon(int n, int x[], int y[], simpleCanvas C) {

		int ymax = 0;
		int ymin = numberOfScanLines;

		BucketOfEdges initial, ending;

		// creating the edge bucket list

		for (int i = 0; i < n; i++) {
			int j = (i + 1) % n;

			BucketOfEdges bucketEdge = new BucketOfEdges();

			// initializing ymax, initialScan and intialX

			bucketEdge.ymax = y[i] > y[j] ? y[i] : y[j];
			bucketEdge.initialScan = y[i] < y[j] ? y[i] : y[j];
			bucketEdge.initialX = y[i] < y[j] ? x[i] : x[j];

			// to check if the slope is positive or negative

			if ((y[j] < y[i] && x[j] <= x[i]) || (y[j] > y[i] && x[j] >= x[i])) {
				bucketEdge.checkSlope = false;
			} else {
				bucketEdge.checkSlope = true;
			}

			bucketEdge.dx = Math.abs(x[j] - x[i]);
			bucketEdge.dy = Math.abs(y[j] - y[i]);
			bucketEdge.sum = 0;

			// edges added to the global edge table

			buckets.add(bucketEdge);

			ymin = ymin > y[i] ? y[i] : ymin;
			ymax = ymax > y[i] ? ymax : y[i];
		}

		// adding edges to the table array list

		BucketOfEdges[] table = new BucketOfEdges[1 + ymax - ymin];

		for (BucketOfEdges edge : buckets) {

			int tableIndex = edge.initialScan - ymin;

			// adding edges to active edge list

			if (table[tableIndex] == null) {
				table[tableIndex] = edge;
			} else {
				edge.next = table[tableIndex];
				table[tableIndex] = edge;
			}

		}
		for (int pixelY = ymin; pixelY <= ymax; pixelY++) {

			add(table[pixelY - ymin]);
			deleteEdge(pixelY);
			sort();

			for (int j = 0; j < arrList.size() - 1; j = j + 2) {

				// grouping edges to display pixels of edges alternatively

				initial = arrList.get(j);
				ending = arrList.get(j + 1);

				for (int pixelX = initial.initialX; pixelX < ending.initialX; pixelX++) {
					C.setPixel(pixelX, pixelY);
				}

				initial.changeSumX();
				ending.changeSumX();
			}

		}
		arrList.clear();
		buckets.clear();
	}

	// add all edges
	public void add(BucketOfEdges edge) {

		BucketOfEdges current = edge;

		while (current != null) {

			arrList.add(current);
			current = current.next;
		}
	}

	// delete dead edges
	public void deleteEdge(int y) {

		for (int i = 0; i < arrList.size(); i++) {

			if (arrList.get(i).ymax <= y) {
				arrList.remove(i);
			}
		}
	}

	// sort
	public void sort() {

		Collections.sort(arrList, new Comparator<BucketOfEdges>() {

			public int compare(BucketOfEdges o1, BucketOfEdges o2) {

				Integer x1, x2;
				x1 = o1.initialX;
				x2 = o2.initialX;
				return x1.compareTo(x2);
			}
		});
	}

	class BucketOfEdges {

		int initialScan;
		int ymax;
		int dx;
		int dy;
		int sum;
		BucketOfEdges next;
		int initialX;
		boolean checkSlope;

		// to update the value of sum and X
		public void changeSumX() {
			sum += dx;

			while (sum > dy) {
				sum -= dy;

				if (checkSlope) {
					initialX--;
				} else {
					initialX++;
				}
			}

		}

	}

}
