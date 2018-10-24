package fr.cs.sio.paint;

import fr.cs.sio.paint.model.Circle;
import fr.cs.sio.paint.model.Point;
import fr.cs.sio.paint.model.Polygon;
import fr.cs.sio.paint.model.Rectangle;
import fr.cs.sio.paint.model.Shape;
import fr.cs.sio.paint.ui.Paintable;
import fr.cs.sio.paint.ui.PaintableCanvas;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String... params) {

        String content;
        try {
            content = getUrlContent("https://pastebin.com/raw/5n10aqyP");
        } catch (IOException ex) {
            System.out.println("Error when getting content: " + ex.toString());
            return;
        }

        System.out.println(content);

        //List<Paintable> l = createPaintablesFromContent(content);

        List<Paintable> l = new ArrayList<>();
        l.add(new Rectangle(30, 40, 100, 200));
        List<Point> p = new ArrayList<Point>();
        p.add(new Point(50, 70));
        p.add(new Point(100, 120));
        p.add(new Point(20, 150));
        l.add(new Polygon(p));

        // Instantiate our custom panel to display the paintables.
        PaintableCanvas canvas = new PaintableCanvas(l);
        canvas.setBackground(java.awt.Color.WHITE);

        // UI classes are provided in the javax.swing.* package.
        // We create a window, give it a size, add the panel (the default is fullscreen) and display it.
        JFrame window = new JFrame("Photoshop");
        window.setSize(640, 480);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(canvas);
        window.setVisible(true);
    }

    private static String getUrlContent(String address) throws IOException {
        // This constructor may throw MalformedUrlException if the "url" parameter is not a valid URL.
        // We don't catch the error here, instead it propagates to the calling method since our signature declares it.
        URL url = new URL(address);

        // 1. Open a connection to the URL.
        // 2. Get an InputStream from which we can read incoming data (low level function, byte per byte).
        // 3. Create an InputStreamReader that is able to consume the InputStream data an process it.
        // 4. Wrap it into a BufferedReader that adds the ability to read the content line by line thanks to a buffer.
        // ...and put it inside the "()" part of a try-with-resource block to avoid leaking the connection.
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        url.openConnection()/* 1 */
                                .getInputStream()/* 2 */
                )/* 3 */
        )/* 4 */) {

            // It is more efficient to use a StringBuilder rather than String concatenation (+) in a loop.
            StringBuilder sb = new StringBuilder();

            // At this point, no data has been transferred yet!

            // Declare a variable that will hold the content of a line.
            String line;
            // In the same statement, get the next line from the reader, assign it to "line" and check if it is not null.
            // The readLine() call is the one that actually makes the data transfer to happen.
            // This "while" loop will break when the readLine() method will return null (content is all read).
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // The transfer is done!
            return sb.toString();

            // The Closable.close() method of the reader will be called at the end of the block, even in case of error.
        }
    }

    private static List<Paintable> createPaintablesFromContent(String content) {
        return null;
    }

    public static void demos(String... params) {

        // Manipulation of primitive types.
        int a = 2;
        long b;
        b = 3;
        float c = 2.37f;
        char d = 'e';
        double e = b / 3.;
        b = (long) c;
        // Call a static method of java.lang.Math.
        b = Math.round(c);
        boolean f = true;

        // Implicit casting if no precision loss
        c = a + b;
        // Explicit casting if precision loss
        c = (float) ((a + b) / d);

        // String is a transparent type.
        String helloWorld = "Hello " + "world!";
        // Log to the console.
        System.out.println(helloWorld);

        // Check for conditions.
        if (a == 2) {
            System.out.println("a is 2");
        } else {
            System.out.println("a is not 2");
        }
        if (helloWorld.contains("r")) {
            System.out.println("helloWorld contains r");
        }

        // Basic loop (initialization; break condition; iteration statement).
        for (int i = 0; i < 10; i++) {
            System.out.println("loop: " + i);
            if (i == 2) break;
        }

        // Test multiple cases on a variable (ints and strings).
        switch (a) {
            case 1:
            case 2:
                System.out.println("a is 2 or 1");
                // Don't forget to exit the switch!
                break;
            case 3:
                System.out.println("a is 3");
                break;
        }

        // Instantiate objects with "new", and call a constructor.
        Rectangle r1 = new fr.cs.sio.paint.model.Rectangle(40, 20, 20, 40);
        // Call methods to change attributes
        r1.setWidth(200);
        r1.setHeight(100);
        r1.setOrigin(new Point(20, 50));

        // Thanks to polymorphism, an instance of Rectangle can be the value of a variable declared as Shape.
        // But only properties & methods declared in Shape are available on s, even if the actual value is a Rectangle.
        Shape s2 = new Rectangle(30, 60, 20, 80);
        // getArea() is available because it is declared in Shape (abstractly), even is the concrete implementation is in Rectangle.
        double area = s2.getArea();

        // It is possible to check a variable for a more precise subclass.
        if (s2 instanceof Rectangle) {
            // Since we checked, we can safely "cast" the variable to a Rectangle an access the specific properties.
            // But this style of coding can lead to runtime errors (vs compile-time errors), so use with caution!
            ((Rectangle) s2).setWidth(200);
        }

        // Declare and create an empty array (fixed size).
        Rectangle[] rects = new Rectangle[2];
        // Assign a value to an array.
        rects[0] = r1;
        // An explicit cast is required here because r2 is only declared as a Shape.
        rects[1] = (Rectangle) s2;
        // Short array initializers.
        boolean[] bools = new boolean[] { true, false };
        int[] ints = { 12, 56 };

        // Objects are stored in an array by reference.
        r1.setHeight(400);
        Rectangle rectFromArray = rects[0];
        System.out.println("Height of r1 is " + r1.getHeight());
        rectFromArray.setHeight(500);
        System.out.println("Height of r1 is " + r1.getHeight());

        // Primitives are stored in an array by value.
        int t = 3;
        int[] test = { t };
        t = 2;
        System.out.println("Array value is " + test[0]);

        // Check equality of objects (only check memory address, except overrided).
        boolean eq = r1.equals(s2);

        // The List interface exposes a generic type parameter.
        // The type parameter defines the signature of methods such as add().
        List<Shape> list = new ArrayList<>();
        list.add(s2);
        list.add(r1);
        list.remove(s2);
        Shape found = list.get(0);

        Paintable p = new Paintable() {

            @Override
            public void paint(Graphics g) {

            }
        };

    }

}
