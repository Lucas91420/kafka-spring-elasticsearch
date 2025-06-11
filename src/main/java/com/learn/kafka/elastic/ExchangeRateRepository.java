package com.learn.kafka.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ExchangeRateRepository extends ElasticsearchRepository<ExchangeRateDocument, String> {}
