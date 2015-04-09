/*******************************************************************************
 * Copyright 2011, Mysema Ltd
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *******************************************************************************/
package br.com.anteros.persistence.dsl.osql.types.template;

import java.util.List;

import br.com.anteros.core.utils.ListUtils;
import br.com.anteros.persistence.dsl.osql.types.Template;
import br.com.anteros.persistence.dsl.osql.types.TemplateExpression;
import br.com.anteros.persistence.dsl.osql.types.TemplateExpressionImpl;
import br.com.anteros.persistence.dsl.osql.types.TemplateFactory;
import br.com.anteros.persistence.dsl.osql.types.Visitor;
import br.com.anteros.persistence.dsl.osql.types.expr.StringExpression;

/**
 * StringTemplate defines custom String expressions
 *
 * @author tiwe
 *
 */
public class StringTemplate extends StringExpression implements TemplateExpression<String> {

    private static final long serialVersionUID = 3181686132439356614L;

    public static StringExpression create(String template) {
        return new StringTemplate(TemplateFactory.DEFAULT.create(template), ListUtils.of());
    }
    
    public static StringExpression create(String template, Object one) {
        return new StringTemplate(TemplateFactory.DEFAULT.create(template), ListUtils.of(one));
    }
    
    public static StringExpression create(String template, Object one, Object two) {
        return new StringTemplate(TemplateFactory.DEFAULT.create(template), ListUtils.of(one, two));
    }
    
    public static StringExpression create(String template, Object... args) {
        return new StringTemplate(TemplateFactory.DEFAULT.create(template), ListUtils.copyOf(args));
    }

    public static StringExpression create(Template template, Object... args) {
        return new StringTemplate(template, ListUtils.copyOf(args));
    }

    private final TemplateExpressionImpl<String> templateMixin;

    public StringTemplate(Template template, List<?> args) {
        super(new TemplateExpressionImpl<String>(String.class, template, args));
        this.templateMixin = (TemplateExpressionImpl<String>)mixin;
    }

    @Override
    public final <R,C> R accept(Visitor<R,C> v, C context) {
        return v.visit(templateMixin, context);
    }
    
    @Override
    public Object getArg(int index) {
        return templateMixin.getArg(index);
    }

    @Override
    public List<?> getArgs() {
        return templateMixin.getArgs();
    }

    @Override
    public Template getTemplate() {
        return templateMixin.getTemplate();
    }

}
