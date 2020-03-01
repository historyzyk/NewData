package com.sixin.iot.mapper;
import java.util.List;
import com.sixin.iot.domain.Soilusetype;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Component
public interface SoilTypeMapper {
    public List<Soilusetype> select();
}
