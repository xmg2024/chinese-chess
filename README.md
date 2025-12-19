# 中国象棋 Android 游戏

一个简单的中国象棋Android游戏，包含残局挑战和不同难度的AI对手。

## 功能特点

- 完整的中国象棋游戏规则实现
- 多种难度级别的AI对手
- 残局挑战模式
- 单机游戏无需网络连接

## 技术实现

- 使用原生Android开发
- Java语言编写
- 自定义View绘制棋盘和棋子
- 包含AI算法实现

## 安装说明

1. 克隆项目到本地
2. 使用Android Studio打开项目
3. 构建并运行应用

## 使用方法

1. 点击"开始游戏"与AI对战
2. 点击"残局挑战"解决经典残局问题

## 项目结构

- `ChessBoard.java` - 棋盘绘制类
- `ChessPiece.java` - 棋子数据模型
- `ChessGame.java` - 游戏逻辑控制
- `AIPlayer.java` - AI玩家实现
- `EndgamePuzzles.java` - 残局挑战数据

## 构建APK

要构建发布版APK，请在Android Studio中选择Build > Generate Signed Bundle / APK，然后按照向导操作。

## 许可证

MIT License