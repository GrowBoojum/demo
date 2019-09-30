package com.example.demo;

import com.example.demo.api.VehicleApi;
import com.example.demo.entities.Vehicle;
import com.example.demo.service.VehicleService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class VehicleTest {
    @Test
    public void secondTest() {
        //1. Setup
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("1","mkyong in action"),
                new Vehicle("2","abc in action"));


        VehicleApi mockito = Mockito.mock(VehicleApi.class);

        when(mockito.findById("1")).thenReturn(Optional.ofNullable(vehicles.get(0)));

        VehicleService obj = new VehicleService(mockito);

        //2. Test method
        Optional<Vehicle> v = obj.getVehicle("1");

        //3. Verify result
        assertEquals(v.get().getId(), "1");
    }
}