package com.sixin.iot.service;

import com.sixin.iot.domain.Tersga1;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface Soil3DService {
    public Tersga1 sumters();
    public List<Tersga1> sumterm();
}
