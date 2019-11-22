from flask import Flask, request
from flask_restful import Resource, Api

app= Flask(__name__)
api= Api(app)

class HelloWorld(Resource):
	def get(self):
		return {'msg':'Grupo 02'}
	def post(self):
		some_json= request.get_json()
		#import mpu.io
		#data = mpu.io.read('example.json')
		#mpu.io.write('example.json', some_json)
		return {'you sent': some_json}, 201

class Multi(Resource):
	def get(self, num):
		return{'result': num*10}

api.add_resource(HelloWorld,'/')
api.add_resource(Multi, '/multi/<int:num>')

if __name__ == '__main__':
	app.run(debug=True)