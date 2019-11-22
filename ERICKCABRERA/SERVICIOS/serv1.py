from flask import Flask, jsonify, request
app = Flask(__name__)

@app.route('/', methods=['GET', 'POST' ])
def index():
	if(request.method== 'POST'):
		some_json= request.get_text();
		return jsonify({'you:sent' : some_json}),201
	else:
		return jsonify({"about": "Hello Wordl!"})

@app.route('/ope/<int:num>', methods=['GET'])
def mensaje1(num):
        String mensaje;
        switch (num) {
            case 1:  mensaje = "Eliminado";
                     break;
            case 2:  mensaje = "Editado";
                     break;
            case 3:  mensaje = "Error";
                     break;
            default: mensaje = "Invalid mensaje";
                     break;
        }
	return jsonify({"about": mensaje})

if __name__ == '__main__':
	app.run(debug=True)