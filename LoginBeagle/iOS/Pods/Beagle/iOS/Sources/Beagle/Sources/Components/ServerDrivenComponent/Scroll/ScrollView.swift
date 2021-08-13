/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/// Component is a specialized container that will display its components in a Scroll.
public struct ScrollView: ServerDrivenComponent, AutoInitiableAndDecodable, HasContext {
    
    /// Defines a list of components to be displayed in the `ScrollView`.
    public let children: [ServerDrivenComponent]?
    
    /// Defines the scroll roll direction on screen.
    public let scrollDirection: ScrollAxis?
    
    /// Determines if the Scroll bar is displayed or not. It is displayed by default.
    public let scrollBarEnabled: Bool?
    
    /// Defines the context that be set to `ScrollView`.
    public let context: Context?

// sourcery:inline:auto:ScrollView.Init
    public init(
        children: [ServerDrivenComponent]? = nil,
        scrollDirection: ScrollAxis? = nil,
        scrollBarEnabled: Bool? = nil,
        context: Context? = nil
    ) {
        self.children = children
        self.scrollDirection = scrollDirection
        self.scrollBarEnabled = scrollBarEnabled
        self.context = context
    }
// sourcery:end
    
    #if swift(<5.3)
    public init(
        scrollBarEnabled: Bool? = nil,
        scrollDirection: ScrollAxis? = nil,
        context: Context? = nil,
        @ChildBuilder
        _ children: () -> ServerDrivenComponent
    ) {
        self.init(children: [children()], scrollDirection: scrollDirection, scrollBarEnabled: scrollBarEnabled, context: context)
    }
    #endif
    
    public init(
        scrollBarEnabled: Bool? = nil,
        scrollDirection: ScrollAxis? = nil,
        context: Context? = nil,
        @ChildrenBuilder
        _ children: () -> [ServerDrivenComponent]
    ) {
        self.init(children: children(), scrollDirection: scrollDirection, scrollBarEnabled: scrollBarEnabled, context: context)
    }

}

public enum ScrollAxis: String, Decodable {
    case vertical = "VERTICAL"
    case horizontal = "HORIZONTAL"
    
    public var flexDirection: Flex.FlexDirection {
        switch self {
        case .vertical:
            return .column
        case .horizontal:
            return .row
        }
    }
}
