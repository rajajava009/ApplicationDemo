package com.raja.DemoApplication.repository;

import com.raja.DemoApplication.model.Station;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface IhStationRepository extends PagingAndSortingRepository<Station, String> 
{

    Station findByStationId(String name);

    List<Station> findByName(String name);

    List<Station> findByHdEnabled(boolean hdEnabled);

    void deleteByStationId(String stationId);

    void deleteAllByName(String name);
}