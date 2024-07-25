 ![image](https://github.com/278359100/logs/blob/main/qrcode_for_gh_ee8d175bb0fd_258.jpg)

Integrate the Timber library to dynamically output specified logs, encapsulating it into a module for use by other modules!

1. Configure a specific file name to allow log output.
    Logs are outputted selectively --- only for the file names of interest.
2. Include the file name and line number in the logs.
    Link logs to code --- clicking on the underlined file name in the log will take you directly to the associated code location.

Example:
(SearchCardActivity.java:58):getTablesVersion9999999999 [Caller: loadTables]


引入Timber库动态输出指定日志,封装成模块提供给其他模块调用！

1.配置指定文件名来允许日志输出。
     日志只输出重点---只输出自己关心的文件名的日志。
2.日志上带上文件名行号。
     日志关联到代码---在日志里点击带下划线的文件名就能定位到日志的关联代码位置。

示例：
 (SearchCardActivity.java:58):getTablesVersion9999999999 [Caller: loadTables]


CallTimber.start();// switch open logs
CustomTimber.d( "getTablesVersion" + getTablesVersion(17));// call log.
