import java.time.LocalDate;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 6, 13);
        String customerName = "John Doe";
        LocalDate reservationStart = LocalDate.of(2024, 6, 3);

        // Example input data
        String vehicleType = "car";
        String vehicleBrand = "Mitsubishi";
        String vehicleModel = "Mirage";
        double vehicleValue = 15000.00;
        int safetyRating = 3;
        int rentalPeriod = 10; // in days
        int riderAge = 24; // relevant for motorcycles
        int driverExperience = 6; // relevant for cargo vans

        double rentalCost = calculateRentalCost(vehicleType, rentalPeriod);
        double dailyCost = rentalCost / rentalPeriod;
        double insuranceCost = 15.00; // Fixed total insurance cost
        double dayInsurance = 1.50; // Fixed daily insurance cost
        double totalCost = rentalCost + insuranceCost;

        generateInvoice(vehicleType, vehicleBrand, vehicleModel, vehicleValue, safetyRating, rentalPeriod, rentalCost, insuranceCost, totalCost, date, customerName, reservationStart, dailyCost, dayInsurance);
    }

    static double calculateRentalCost(String vehicleType, int rentalPeriod) {
        double dailyCost;

        if (rentalPeriod > 7) {
            switch (vehicleType.toLowerCase()) {
                case "car":
                    dailyCost = 15;
                    break;
                case "motorcycle":
                    dailyCost = 10;
                    break;
                case "cargo van":
                    dailyCost = 40;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid vehicle type");
            }
        } else {
            switch (vehicleType.toLowerCase()) {
                case "car":
                    dailyCost = 20;
                    break;
                case "motorcycle":
                    dailyCost = 15;
                    break;
                case "cargo van":
                    dailyCost = 50;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid vehicle type");
            }
        }

        return dailyCost * rentalPeriod;
    }

    static void generateInvoice(String vehicleType, String vehicleBrand, String vehicleModel, double vehicleValue, int safetyRating, int rentalPeriod, double rentalCost, double insuranceCost, double totalCost, LocalDate date, String customerName, LocalDate reservationStart, double dailyCost, double dayInsurance) {
        System.out.println("A " + vehicleType + " that is valued at " + vehicleValue + " , and has a security rating of " + safetyRating);
        System.out.println("");
        System.out.println("XXXXXXXXXX");
        System.out.println("Date: " + date);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Rented Vehicle Model: " + vehicleBrand + " " + vehicleModel);
        System.out.println("");
        System.out.println("Reservation start date: " + reservationStart);
        System.out.println("Actual rental days: " + rentalPeriod);
        System.out.println("");
        System.out.println("Actual Return date: " + date);
        System.out.println("Actual rental days: " + rentalPeriod);
        System.out.println("");
        System.out.println(String.format("Rental cost per day: $%.2f", dailyCost));
        System.out.println(String.format("Insurance per day: $%.2f", dayInsurance));
        System.out.println("");
        System.out.println(String.format("Total rent: $%.2f", rentalCost));
        System.out.println(String.format("Total insurance: $%.2f", insuranceCost));
        System.out.println(String.format("Total: $%.2f", totalCost));
        System.out.println("XXXXXXXXXX");
    }
}
