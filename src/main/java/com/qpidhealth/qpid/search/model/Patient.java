package com.qpidhealth.qpid.search.model;

import java.util.List;
import java.util.Objects;

import com.google.common.base.MoreObjects;

public class Patient {
	private final Long id;
	private final String name;
	private final List<String> documents; // id ::: date ::: contents

	public Patient(Long id, String name, List<String> documents) {
		this.id = id;
		this.name = name;
		this.documents = documents;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getDocuments() {
		return documents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, documents);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("name", name).add("documents", documents).toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Patient)) {
			return false;
		}
		Patient other = (Patient) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(documents, other.documents);
	}
}