## Команды Docker для Windows

### Создание тома для данных Prometheus
```bash
docker volume create prometheus-data
```

### Запуск контейнера Prometheus
```bash
docker run --rm --detach --name my-prometheus --publish 9090:9090 --volume prometheus-data:/prometheus --volume .\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
```

### Запуск контейнера Grafana
```bash
docker run -d --name=grafana -p 3000:3000 grafana/grafana
```
