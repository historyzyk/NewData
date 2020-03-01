package com.sixin.iot.service;
import com.sixin.iot.domain.Soilusetype;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ISoiluseTypeService {
    public List<Soilusetype> select();
}
