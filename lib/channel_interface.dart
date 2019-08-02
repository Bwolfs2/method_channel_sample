import 'package:flutter/services.dart';
import 'package:method_channel_sample/clientes.dart';

class ChannelInterface
{

 static const platform = const MethodChannel('flutter.native/helper');

    var _cliente = Clientes(
      alunos: ["Teste", "casa" , "objeto"],
      createdDate: DateTime.now(),
      id: 1,
      title: "Alunos"

    );


    Future passarMultipliosParametro() async {
      await platform.invokeMethod('foo',_cliente.toJson());
    }
}