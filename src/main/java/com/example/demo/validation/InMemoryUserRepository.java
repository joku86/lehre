package com.example.demo.validation;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements CrudRepository<User2, Long> {
	private final Map<Long, User2> users = new ConcurrentHashMap<>();

	@Override
	public <S extends User2> S save(S entity) {
		users.put(entity.id = System.nanoTime(), entity);
		return entity;
	}

	@Override
	public <S extends User2> Iterable<S> saveAll(Iterable<S> entities) {
		Stream<S> stream = StreamSupport.stream(entities.spliterator(), false).map(this::save);
		return stream::iterator;
	}

	@Override
	public Optional<User2> findById(Long id) {
		return Optional.ofNullable(users.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return users.containsKey(id);
	}

	@Override
	public Iterable<User2> findAll() {
		return Collections.unmodifiableCollection(users.values());
	}

	@Override
	public Iterable<User2> findAllById(Iterable<Long> ids) {
		Stream<User2> stream = StreamSupport.stream(ids.spliterator(), false).map(users::get).filter(Objects::nonNull);
		return stream::iterator;
	}

	@Override
	public long count() {
		return users.size();
	}

	@Override
	public void deleteById(Long id) {
		users.remove(id);
	}

	@Override
	public void delete(User2 entity) {
		deleteById(entity.id);
	}

	@Override
	public void deleteAll(Iterable<? extends User2> entities) {
		entities.forEach(entity -> deleteById(entity.id));
	}

	@Override
	public void deleteAll() {
		users.clear();
	}

}
