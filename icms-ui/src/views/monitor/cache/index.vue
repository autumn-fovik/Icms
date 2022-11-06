<template>
  <div>
    <n-grid :x-gap="20" y-gap="20" >
      <n-gi :span="24">
        <n-card size="small" :segmented="{content : true}">
          <template #header>
            基本信息
          </template>
          <n-descriptions label-placement="left"
                          bordered
                          :column="4"
                        >
            <n-descriptions-item label="Redis版本">{{ cache.info.redis_version }}</n-descriptions-item>
            <n-descriptions-item label="运行模式">{{ cache.info.redis_mode == "standalone" ? "单机" : "集群" }}</n-descriptions-item>
            <n-descriptions-item label="端口">{{ cache.info.tcp_port }}</n-descriptions-item>
            <n-descriptions-item label="客户端数">{{ cache.info.connected_clients }}</n-descriptions-item>
            <n-descriptions-item label="运行时间（天）">{{ cache.info.uptime_in_days }}</n-descriptions-item>
            <n-descriptions-item label="使用内存">{{ cache.info.used_memory_human }}</n-descriptions-item>
            <n-descriptions-item label="使用CPU">{{ parseFloat(cache.info.used_cpu_user_children).toFixed(2) }}</n-descriptions-item>
            <n-descriptions-item label="内存配置">{{ cache.info.maxmemory_human }}</n-descriptions-item>
            <n-descriptions-item label="AOF是否开启">{{ cache.info.aof_enabled == "0" ? "否" : "是" }}</n-descriptions-item>
            <n-descriptions-item label="RDB是否成功">{{ cache.info.rdb_last_bgsave_status }}</n-descriptions-item>
            <n-descriptions-item label="Key数">{{ cache.dbSize }}</n-descriptions-item>
            <n-descriptions-item label="网络入口/出口">{{ cache.info.instantaneous_input_kbps }}kps/{{cache.info.instantaneous_output_kbps}}kps</n-descriptions-item>
          </n-descriptions>
        </n-card>
      </n-gi>
      <n-gi :span="12">
        <n-card>
          <template #header>
            命令统计
          </template>
          <div ref="commandstats" style="height: 420px" />
        </n-card>
      </n-gi>
      <n-gi :span="12">
        <n-card>
          <template #header>
            内存消耗
          </template>
          <div ref="usedmemory" style="height: 420px" />
        </n-card>
      </n-gi>
    </n-grid>
  </div>
</template>

<script setup lang="ts">

import {redis} from "@/apis/monitorApi";
import * as echarts from 'echarts';

const cache = ref({
  commandStats: [
    {
      name: ' get',
      value: ' 2651'
    },
    {
      name: ' info',
      value: ' 9'
    },
    {
      name: ' dbsize',
      value: ' 4'
    },
    {
      name: ' setex',
      value: ' 19'
    },
    {
      name: ' hello',
      value: ' 9'
    }
  ],
  info:{
  io_threaded_reads_processed: ' 0',
  tracking_clients: ' 0',
  uptime_in_seconds: ' 21731',
  cluster_connections: ' 0',
  current_cow_size: ' 0',
  maxmemory_human: ' 0B',
  aof_last_cow_size: ' 0',
  master_replid2: ' 0000000000000000000000000000000000000000',
  rdb_last_load_keys_expired: ' 0',
  mem_replication_backlog: ' 0',
  aof_rewrites: ' 0',
  aof_rewrite_scheduled: ' 0',
  pubsubshard_channels: ' 0',
  mem_total_replication_buffers: ' 0',
  total_net_input_bytes: ' 205692',
  rss_overhead_ratio: ' 1.62',
  mem_cluster_links: ' 0',
  hz: ' 10',
  current_cow_size_age: ' 0',
  redis_build_id: ' a507a0b937977997',
  aof_last_bgrewrite_status: ' ok',
  instantaneous_input_repl_kbps: ' 0.00',
  multiplexing_api: ' epoll',
  client_recent_max_output_buffer: ' 0',
  allocator_resident: ' 4980736',
  evicted_clients: ' 0',
  mem_fragmentation_bytes: ' 7077120',
  repl_backlog_first_byte_offset: ' 0',
  tracking_total_prefixes: ' 0',
  redis_mode: ' standalone',
  redis_git_dirty: ' 0',
  current_cow_peak: ' 0',
  allocator_rss_bytes: ' 3416064',
  repl_backlog_histlen: ' 0',
  io_threads_active: ' 0',
  rss_overhead_bytes: ' 3108864',
  total_system_memory: ' 955248640',
  loading: ' 0',
  evicted_keys: ' 0',
  maxclients: ' 10000',
  cluster_enabled: ' 0',
  redis_version: ' 7.0.5',
  repl_backlog_active: ' 0',
  mem_aof_buffer: ' 0',
  allocator_frag_bytes: ' 335288',
  rdb_saves: ' 6',
  io_threaded_writes_processed: ' 0',
  instantaneous_ops_per_sec: ' 1',
  used_memory_human: ' 990.53K',
  total_error_replies: ' 0',
  role: ' master',
  current_active_defrag_time: ' 0',
  maxmemory: ' 0',
  used_memory_lua: ' 31744',
  async_loading: ' 0',
  rdb_current_bgsave_time_sec: ' -1',
  used_memory_startup: ' 862880',
  used_cpu_sys_main_thread: ' 20.939889',
  lazyfree_pending_objects: ' 0',
  used_memory_dataset_perc: ' 84.41%',
  used_memory_vm_eval: ' 31744',
  allocator_frag_ratio: ' 1.27',
  arch_bits: ' 64',
  used_cpu_user_main_thread: ' 21.750448',
  mem_clients_normal: ' 23296',
  expired_time_cap_reached_count: ' 0',
  unexpected_error_replies: ' 0',
  mem_fragmentation_ratio: ' 7.99',
  aof_last_rewrite_time_sec: ' -1',
  master_replid: ' be3a754dc673aadc2bf0f6b343673db211ee7aaa',
  aof_rewrite_in_progress: ' 0',
  config_file: ' ',
  lru_clock: ' 6606034',
  maxmemory_policy: ' noeviction',
  total_net_repl_input_bytes: ' 0',
  run_id: ' 95494d1b940b511b886688b9d8ee3b3231140eda',
  latest_fork_usec: ' 944',
  tracking_total_items: ' 0',
  total_commands_processed: ' 2691',
  expired_keys: ' 4',
  used_memory: ' 1014304',
  module_fork_in_progress: ' 0',
  dump_payload_sanitizations: ' 0',
  mem_clients_slaves: ' 0',
  keyspace_misses: ' 5',
  server_time_usec: ' 1667550418955432',
  executable: ' /data/redis-server',
  total_eviction_exceeded_time: ' 0',
  number_of_functions: ' 0',
  lazyfreed_objects: ' 0',
  db0: 'keys=1,expires=1,avg_ttl=1226850',
  used_memory_peak_human: ' 1008.83K',
  used_memory_vm_total: ' 64512',
  keyspace_hits: ' 2646',
  rdb_last_cow_size: ' 663552',
  used_memory_overhead: ' 886488',
  active_defrag_hits: ' 0',
  tcp_port: ' 6379',
  uptime_in_days: ' 0',
  used_memory_scripts_eval: ' 0',
  used_memory_vm_functions: ' 32768',
  used_memory_peak_perc: ' 98.19%',
  current_save_keys_processed: ' 0',
  blocked_clients: ' 0',
  total_reads_processed: ' 2693',
  expire_cycle_cpu_milliseconds: ' 642',
  sync_partial_err: ' 0',
  used_memory_scripts_human: ' 184B',
  aof_current_rewrite_time_sec: ' -1',
  aof_enabled: ' 0',
  process_supervised: ' no',
  master_repl_offset: ' 0',
  used_memory_dataset: ' 127816',
  aof_rewrites_consecutive_failures: ' 0',
  total_net_repl_output_bytes: ' 0',
  used_cpu_user: ' 21.765404',
  rdb_last_bgsave_status: ' ok',
  tracking_total_keys: ' 0',
  atomicvar_api: ' c11-builtin',
  allocator_rss_ratio: ' 3.18',
  client_recent_max_input_buffer: ' 20480',
  clients_in_timeout_table: ' 0',
  aof_last_write_status: ' ok',
  reply_buffer_shrinks: ' 869',
  mem_allocator: ' jemalloc-5.2.1',
  used_memory_scripts: ' 184',
  used_memory_peak: ' 1033040',
  number_of_libraries: ' 0',
  used_memory_vm_total_human: ' 63.00K',
  process_id: ' 1',
  master_failover_state: ' no-failover',
  used_cpu_sys: ' 20.942792',
  repl_backlog_size: ' 1048576',
  connected_slaves: ' 0',
  current_save_keys_total: ' 0',
  reply_buffer_expands: ' 869',
  gcc_version: ' 10.2.1',
  total_system_memory_human: ' 911.00M',
  used_memory_functions: ' 184',
  sync_full: ' 0',
  connected_clients: ' 1',
  monotonic_clock: ' POSIX clock_gettime',
  module_fork_last_cow_size: ' 0',
  total_active_defrag_time: ' 0',
  instantaneous_output_repl_kbps: ' 0.00',
  total_writes_processed: ' 2684',
  allocator_active: ' 1564672',
  total_net_output_bytes: ' 2808343',
  pubsub_channels: ' 0',
  current_fork_perc: ' 0.00',
  active_defrag_key_hits: ' 0',
  rdb_changes_since_last_save: ' 0',
  instantaneous_input_kbps: ' 0.08',
  used_memory_rss_human: ' 7.71M',
  configured_hz: ' 10',
  expired_stale_perc: ' 0.00',
  active_defrag_misses: ' 0',
  used_cpu_sys_children: ' 0.052805',
  number_of_cached_scripts: ' 0',
  sync_partial_ok: ' 0',
  used_memory_lua_human: ' 31.00K',
  rdb_last_save_time: ' 1667550293',
  pubsub_patterns: ' 0',
  slave_expires_tracked_keys: ' 0',
  redis_git_sha1: ' 00000000',
  used_memory_rss: ' 8089600',
  rdb_last_bgsave_time_sec: ' 0',
  os: ' Linux 5.10.16.3-microsoft-standard-WSL2 x86_64',
  mem_not_counted_for_evict: ' 0',
  active_defrag_running: ' 0',
  rejected_connections: ' 0',
  current_eviction_exceeded_time: ' 0',
  total_forks: ' 6',
  active_defrag_key_misses: ' 0',
  allocator_allocated: ' 1229384',
  instantaneous_output_kbps: ' 1.53',
  second_repl_offset: ' -1',
  rdb_last_load_keys_loaded: ' 0',
  rdb_bgsave_in_progress: ' 0',
  used_cpu_user_children: ' 0.029602',
  total_connections_received: ' 9',
  migrate_cached_sockets: ' 0',
},
  dbSize: ' 1'
})
// 统计命令信息
const commandstats = ref( null)
    // 使用内存
const  usedmemory = ref( null)
const initGet = () => {
  redis().then(resp => {
    cache.value = resp.data
    const commandstatsIntance = echarts.init(commandstats.value as any, "macarons");
    commandstatsIntance.setOption({
      tooltip: {
        trigger: "item",
        formatter: "{a} <br/>{b} : {c} ({d}%)"
      },
      series: [
        {
          name: "命令",
          type: "pie",
          roseType: "radius",
          radius: [15, 95],
          center: ["50%", "38%"],
          data: resp.data.commandStats,
          animationEasing: "cubicInOut",
          animationDuration: 1000
        }
      ]
    });
    const usedmemoryInstance = echarts.init(usedmemory.value as any, "macarons");
    usedmemoryInstance.setOption({
      tooltip: {
        formatter: "{b} <br/>{a} : " + cache.value.info.used_memory_human
      },
      series: [
        {
          name: "峰值",
          type: "gauge",
          min: 0,
          max: 1000,
          detail: {
            formatter: cache.value.info.used_memory_human
          },
          data: [
            {
              value: parseFloat(cache.value.info.used_memory_human),
              name: "内存消耗"
            }
          ]
        }
      ]
    })
  })
}

initGet()
</script>

<style scoped>

</style>