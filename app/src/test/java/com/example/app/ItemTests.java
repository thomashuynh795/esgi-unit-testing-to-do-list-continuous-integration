package com.example.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTests {

	private Item item;

	@BeforeEach
	public void setUp() {
		this.item = Item.builder()
				.content("Hello world!")
				.name("item 1")
				.build();
	}

	@Test 
	public void nominalContentTest() {
		assertTrue(this.item.contentIsValid());
	}

	@Test
	public void contentTooLongTest() {
		this.item.setContent("Nostro locum moderatur et Atratino pudor et quidem aliquis in animadvertere neque et accusationis Atratino sum meum optimi agam liberius admiratus tuus animadvertere Atratino Neque lenius Neque agam moleste debeo moderatur parentemque locum optimi ex te neque suscepisset admiratus moderatur tueri postulabat robustioribus tuum potissimum more lenius tuus poteratis tali dicendi et parentemque enim licentiam sum hunc liberius magis neque nostro et moleste quidem moleste orationi et quod orationi aliquis tuli beneficium postulabat aetas dicendi moderatur meae vobis quod id et tuum meum more esse Tecum dicendi esse fortius more aetas Tecum enim oratione quod pudor agam tuus meae liberius. Nostro locum moderatur et Atratino pudor et quidem aliquis in animadvertere neque et accusationis Atratino sum meum optimi agam liberius admiratus tuus animadvertere Atratino Neque lenius Neque agam moleste debeo moderatur parentemque locum optimi ex te neque suscepisset admiratus moderatur tueri postulabat robustioribus tuum potissimum more lenius tuus poteratis tali dicendi et parentemque enim licentiam sum hunc liberius magis neque nostro et moleste quidem moleste orationi et quod orationi aliquis tuli beneficium postulabat aetas dicendi moderatur meae vobis quod id et tuum meum more esse Tecum dicendi esse fortius more aetas Tecum enim oratione quod pudor agam tuus meae liberius.");
		assertFalse(this.item.contentIsValid());
	}

}
