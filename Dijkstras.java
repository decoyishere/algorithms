int[] distance = new int[n];
        ArrayList<ArrayList<Integer>> predecessors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            predecessors.add(new ArrayList<>());
        }
        distance[s] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> distance[v1] - distance[v2]);
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < Ev.get(u).size(); i++) {
                int v = Ev.get(u).get(i);
                int weight = Ew.get(u).get(i);

                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    predecessors.get(v).clear();
                    predecessors.get(v).add(u);
                    queue.add(v);
                } else if (distance[u] + weight == distance[v]) {
                    if (!predecessors.get(v).contains(u)) {
                        predecessors.get(v).add(u);
                    }
                }
            }
        }
