package be.sourcedbvba.modulith.support.domain.event

import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher

interface EventPublisher {
    fun publishEvents(id: Any, events: List<Event>)
}

class SpringEventPublisher(val applicationEventPublisher: ApplicationEventPublisher): EventPublisher {
    override fun publishEvents(id: Any, events: List<Event>) {
        events.forEach { applicationEventPublisher.publishEvent(it) }
    }

}