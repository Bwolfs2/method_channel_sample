class Clientes {
    int id;
    DateTime createdDate;
    String title;
    List<String> alunos;

    Clientes({
        this.id,
        this.createdDate,
        this.title,
        this.alunos,
    });

    factory Clientes.fromJson(Map<String, dynamic> json) => new Clientes(
        id: json["id"],
        createdDate: DateTime.parse(json["createdDate"]),
        title: json["title"],
        alunos: new List<String>.from(json["alunos"].map((x) => x)),
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "createdDate": createdDate.toIso8601String(),
        "title": title,
        "alunos": new List<dynamic>.from(alunos.map((x) => x)),
    };
}
