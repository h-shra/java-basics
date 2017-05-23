package designpatterns.creational.builder;

public class Car {
    /**
     * Mandatory attributes
     **/
    private Integer wheels;
    private String brand;
    private String model;
    /**
     * Non-mandatory attributes
     **/
    private String color;
    private Integer seats;
    private boolean rearViewCamera;
    private boolean cruiseControl;

    /**
     * Don't let anyone instantiate this class
     */
    private Car() {
    }

    /**
     * Call this from CarBuilder.build()
     */
    private Car(CarBuilder builder) {
        this.wheels = builder.wheels;
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.seats = builder.seats;
        this.rearViewCamera = builder.rearViewCamera;
        this.cruiseControl = builder.cruiseControl;
    }

    public Integer getWheels() {
        return wheels;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getSeats() {
        return seats;
    }

    public boolean hasRearViewCamera() {
        return rearViewCamera;
    }

    public boolean hasCruiseControl() {
        return cruiseControl;
    }

    public static class CarBuilder {
        private Integer wheels;
        private String brand;
        private String model;
        /**
         * Non-mandatory attributes, initialized to default values
         **/
        private String color = "Black";
        private Integer seats = 4;
        private boolean rearViewCamera;
        private boolean cruiseControl;

        public CarBuilder(Integer wheels, String brand, String model) {
            this.wheels = wheels;
            this.brand = brand;
            this.model = model;
        }

        public CarBuilder withColor(String color) {
            color = color;
            return this;
        }

        public CarBuilder withSeats(Integer seats) {
            seats = seats;
            return this;
        }

        public CarBuilder withRearViewCamera(boolean flag) {
            rearViewCamera = flag;
            return this;
        }

        public CarBuilder withCruiseControl(boolean flag) {
            cruiseControl = flag;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }


}
