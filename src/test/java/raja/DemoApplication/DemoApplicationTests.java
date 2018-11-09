package com.raja.DemoApplication;

import com.raja.DemoApplication.model.Station;
import com.raja.DemoApplication.repository.IStationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoApplicationTests {

	@Autowired
	private IhStationRepository stationRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getStationTest() {
	Station station = stationRepository.findByStationId("station-id-test");
		Assert.assertEquals("Verifying Station ID", "station-id-test", station.getStationId());
		Assert.assertEquals("Verifying Call Sign", "call-sign-test", station.getCallSign());
		Assert.assertTrue("Verifying HD is enabled", station.isHdEnabled());
		Assert.assertEquals("Verifying name", "test", station.getName());
	}

	@Test
	public void addStationTest() {
		Station station = new Station();
		station.setStationId("station-id-test-10");
		station.setHdEnabled(false);
		station.setName("test-10");
		station.setCallSign("call-sign-test-10");
		stationRepository.save(station);
		Station station1 = stationRepository.findByStationId("station-id-test-10");
		Assert.assertEquals("Verifying Station ID", "station-id-test-10", station1.getStationId());
		Assert.assertEquals("Verifying Call Sign", "call-sign-test-10", station1.getCallSign());
		Assert.assertFalse("Verifying HD is enabled", station1.isHdEnabled());
		Assert.assertEquals("Verifying name", "test-10", station1.getName());
	}

	@Test
	public void updateStationTest() {
		Station station = stationRepository.findByStationId("station-id-test");
		station.setName("test-3");
		station.setHdEnabled(false);
		stationRepository.save(station);
		Station station1 = stationRepository.findByStationId("station-id-test");
		Assert.assertEquals("Verifying Station ID", "station-id-test", station1.getStationId());
		Assert.assertEquals("Verifying Call Sign", "call-sign-test", station1.getCallSign());
		Assert.assertFalse("Verifying HD is disabled", station1.isHdEnabled());
		Assert.assertEquals("Verifying name", "test-3", station1.getName());
	}

	@Test
	public void  deleteStationTest() {
		Station station = new Station();
		station.setStationId("station-id-test-8");
		station.setHdEnabled(false);
		station.setName("test-8");
		station.setCallSign("call-sign-test-8");
		stationRepository.save(station);
		Station station1 = stationRepository.findByStationId("station-id-test-8");
		Assert.assertNotNull(station1);
		stationRepository.delete(station1.getStationId());
		Station station2 = stationRepository.findByStationId("station-id-test-8");
		Assert.assertNull(station2);
	}

	@Test
	public void getStationByName() {
		Station station = new Station();
		station.setStationId("station-id-test-10");
		station.setHdEnabled(false);
		station.setName("test-10");
		station.setCallSign("call-sign-test-10");
		stationRepository.save(station);
		Station station1 = stationRepository.findByStationId("station-id-test-10");
		Assert.assertNotNull(station1);
		Assert.assertEquals("Verifying Station ID", "station-id-test-10", station1.getStationId());
		Assert.assertEquals("Verifying Call Sign", "call-sign-test-10", station1.getCallSign());
		Assert.assertFalse("Verifying HD is disabled", station1.isHdEnabled());
		Assert.assertEquals("Verifying name", "test-10", station1.getName());
	}


