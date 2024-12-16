package com.proj.mvcjdbc.service;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.model.Shelter;

import java.util.ArrayList;
import java.util.List;

public class GetPoints {
    public static List<Peak> getPeaks(){
        List<Peak> peaks = new ArrayList<>();
        peaks.add(new Peak(1, "Peak 1", 1000));
        peaks.add(new Peak(2, "Peak 2", 2000));
        peaks.add(new Peak(3, "Peak 3", 3000));
        return peaks;
    }

    public static List<Shelter> getShelters(){
        List<Shelter> shelters = new ArrayList<>();
        shelters.add(new Shelter(1, "Shelter 1", 1000));
        shelters.add(new Shelter(2, "Shelter 2", 2000));
        shelters.add(new Shelter(3, "Shelter 3", 3000));
        return shelters;
    }
}
