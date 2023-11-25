package com.example.bankproject.JDBC_template_example.records;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;

public record Company_rec(int id, String name, String inn, String phone) {


}
