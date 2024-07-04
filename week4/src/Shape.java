// Abstract class Shape that defines two abstract methods for surface area and volume
abstract class Shape {
    // Abstract method to calculate surface area
    public abstract double surface_area();

    // Abstract method to calculate volume
    public abstract double volume();
}

// Sphere class that extends Shape
class Sphere extends Shape {
    private double radius;

    // Constructor to initialize radius
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Method to calculate surface area of the sphere
    @Override
    public double surface_area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Method to calculate volume of the sphere
    @Override
    public double volume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }

    // Method to return the sphere's details as a string
    @Override
    public String toString() {
        return "Sphere [radius=" + radius + ", surface_area=" + surface_area() + ", volume=" + volume() + "]";
    }
}

// Cylinder class that extends Shape
class Cylinder extends Shape {
    private double radius;
    private double height;

    // Constructor to initialize radius and height
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Method to calculate surface area of the cylinder
    @Override
    public double surface_area() {
        return 2 * Math.PI * radius * (radius + height);
    }

    // Method to calculate volume of the cylinder
    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    // Method to return the cylinder's details as a string
    @Override
    public String toString() {
        return "Cylinder [radius=" + radius + ", height=" + height + ", surface_area=" + surface_area() + ", volume=" + volume() + "]";
    }
}

// Cone class that extends Shape
class Cone extends Shape {
    private double radius;
    private double height;

    // Constructor to initialize radius and height
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Method to calculate surface area of the cone
    @Override
    public double surface_area() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    // Method to calculate volume of the cone
    @Override
    public double volume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    // Method to return the cone's details as a string
    @Override
    public String toString() {
        return "Cone [radius=" + radius + ", height=" + height + ", surface_area=" + surface_area() + ", volume=" + volume() + "]";
    }
}

// Main class to demonstrate the functionality
class ShapeDemo {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapeArray = new Shape[3];

        // Instantiate one sphere, one cylinder, and one cone
        shapeArray[0] = new Sphere(5.0);
        shapeArray[1] = new Cylinder(3.0, 7.0);
        shapeArray[2] = new Cone(4.0, 6.0);

        // Loop through the array and print out the details of each shape
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}
