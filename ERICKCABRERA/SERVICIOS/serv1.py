from flask import Flask, jsonify, request
app = Flask(__name__)

@app.route('/', methods=['GET', 'POST' ])
def index():
	if(request.method== 'POST'):
		some_json= request.get_text();
		return jsonify({'you:sent' : some_json}),201
	else:
		return jsonify({"msg": "Hello Wordl!"})

@app.route('/oper/<int:num>', methods=['GET'])
def mensaje1(num):
	mensaje="indefinido";
	if(num==1):
		mensaje="Editado";
	if(num==2):
		mensaje="Editado";
	if(num==3):
		mensaje="Error";
	return jsonify({"msg": mensaje})

if __name__ == '__main__':
	app.run(debug=True)