简单的容错机制，任务运行期间， 若执行任务的节点挂掉，会有其他节点代替其继续执行

1、所有节点的instanceName需要保持一致
2、org.quartz.jobStore.isClustered=true
3、任务设置为可恢复JobDetail requestRecovery：true //设置任务可恢复
