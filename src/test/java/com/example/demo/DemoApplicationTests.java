package com.example.demo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.validation.InMemoryUserRepository;
import com.example.demo.validation.User2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

	}
	
	
	@Autowired
	private InMemoryUserRepository reposity;
	@Test
	public void users() {
	
		User2 user1 = new User2( "chris", "chris@b.c" );
		User2 user1Alias = reposity.save( user1 );
		assertNotNull( user1.id );
		assertSame( user1, user1Alias );
		assertNotNull( reposity.findById( user1.id ) );
		User2 user2 = new User2( "cora", "cora@b.c" );
		reposity.save( user2 );
		assertNotEquals( user1, user2 );
		assertNotEquals( user1.id, user2.id );
		Iterable<User2> findAll = reposity.findAllById( Arrays.asList( -1L, user1.id, -2L,
		user2.id, -3L ) );
		Iterator<User2> findAllIterator = findAll.iterator();
		assertEquals( user1, findAllIterator.next() );
		assertEquals( user2, findAllIterator.next() );
		assertFalse( findAllIterator.hasNext() );
	}

}
