package com.victor.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.victor.entities.Enemy1;

class TestEnemy2 {

	@Test
	void test() {
		Enemy1 enemy1 = new Enemy1(0, 0, 0, 0, 0, null);
		assertEquals(false, enemy1.test());
	}
	
}
