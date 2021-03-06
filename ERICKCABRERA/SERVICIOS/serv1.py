from flask import Flask, jsonify, request
app = Flask(__name__)

@app.route('/', methods=['GET', 'POST' ])
def index():
	if(request.method== 'POST'):
		some_json= request.get_text();
		return jsonify({'you:sent' : some_json}),201
	else:
		return jsonify({"msg": "Grupo 02"})

@app.route('/oper/<int:num>', methods=['GET'])
def mensaje1(num):
	mensaje="indefinido";
	if(num==1):
		mensaje="“El Estudiante se ha eliminado correctamente";
	if(num==2):
		mensaje="“El Estudiante se ha editado correctamente";
	if(num==3):
		mensaje="Error";
	return jsonify({"msg": mensaje})

if __name__ == '__main__':
	app.run(debug=True)