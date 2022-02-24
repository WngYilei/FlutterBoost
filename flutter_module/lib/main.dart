import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_module/page/home_page.dart';
import 'package:UIKit/home/dialog_entry_page.dart';

void main() {
  print("------------------------------------main--------------------------");
  CustomFlutterBinding();
  runApp(MyApp());
}

class CustomFlutterBinding extends WidgetsFlutterBinding
    with BoostFlutterBinding {}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  Map<String, FlutterBoostRouteFactory> routerMap = {
    'mainPage': (settings, uniqueId) {
      return CupertinoPageRoute(
          settings: settings,
          builder: (_) {
            Map<String, Object> map = settings.arguments as Map<String, Object>;
            String data = map['data'] as String;
            return HomePage(data);
          });
    },
    'simplePage': (settings, uniqueId) {
      return CupertinoPageRoute(
          settings: settings,
          builder: (_) {
            return DialogEntryPage("弹窗示例");
          });
    },
  };

  Route<dynamic> routeFactory(RouteSettings settings, String uniqueId) {
    print("-----------------setting.name${settings.name}---------------------------------");
    FlutterBoostRouteFactory func = routerMap[settings.name];
    if (func == null) {
      FlutterBoostRouteFactory func1 = routerMap["mainPage"];
      return func1(settings, uniqueId);
    }

    return func(settings, uniqueId);
  }

  Widget appBuilder(Widget home) {
    print("------------------------------------appBuilder--------------------------");
    return MaterialApp(
      home: home,
      debugShowCheckedModeBanner: true,
      builder: (_, __) {
        return home;
      },
    );
  }

  @override
  Widget build(BuildContext context) {

    print("------------------------------------build--------------------------");

    return FlutterBoostApp(
      routeFactory,
      appBuilder: appBuilder,
    );
  }
}

class SimplePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(child: Text('SimplePage')),
    );
  }
}
