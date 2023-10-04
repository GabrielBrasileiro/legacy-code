package humble.adapter

import humble.adapter.entity.Consumer

interface AdapterConsumer {
	fun requireConsumer(): Consumer
}