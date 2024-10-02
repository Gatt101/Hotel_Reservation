package com.backend.Hotel_reservation_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.backend.Hotel_reservation_app.entity")
@ComponentScan(basePackages = "com.backend.Hotel_reservation_app")
public class HotelReservationAppApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(HotelReservationAppApplication.class, args);
	}
}
