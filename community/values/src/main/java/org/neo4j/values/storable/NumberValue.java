/*
 * Copyright (c) 2002-2018 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.values.storable;

public abstract class NumberValue extends ScalarValue
{
    public abstract double doubleValue();

    public abstract long longValue();

    abstract int compareTo( IntegralValue other );

    abstract int compareTo( FloatingPointValue other );

    @Override
    int unsafeCompareTo( Value otherValue )
    {
        if ( otherValue instanceof IntegralValue )
        {
            return compareTo( (IntegralValue) otherValue );
        }
        else if ( otherValue instanceof FloatingPointValue )
        {
            return compareTo( (FloatingPointValue) otherValue );
        }
        else
        {
            throw new IllegalArgumentException( "Cannot compare different values" );
        }
    }

    @Override
    public abstract Number asObjectCopy();

    @Override
    public Number asObject()
    {
        return asObjectCopy();
    }

    @Override
    public final boolean equals( boolean x )
    {
        return false;
    }

    @Override
    public final boolean equals( char x )
    {
        return false;
    }

    @Override
    public final boolean equals( String x )
    {
        return false;
    }

    @Override
    public ValueGroup valueGroup()
    {
        return ValueGroup.NUMBER;
    }

    public abstract NumberValue minus( long b );

    public abstract NumberValue minus( double b );

    public abstract NumberValue plus( long b );

    public abstract NumberValue plus( double b );

    public abstract NumberValue times( long b );

    public abstract NumberValue times( double b );

    public NumberValue minus( NumberValue numberValue )
    {
        if ( numberValue instanceof IntegralValue )
        {
            return minus( numberValue.longValue() );
        }
        else if ( numberValue instanceof FloatingPointValue )
        {
            return minus( numberValue.doubleValue() );
        }
        else
        {
            throw new IllegalArgumentException( "Cannot subtract " + numberValue );
        }
    }

    public NumberValue plus( NumberValue numberValue )
    {
        if ( numberValue instanceof IntegralValue )
        {
            return plus( numberValue.longValue() );
        }
        else if ( numberValue instanceof FloatingPointValue )
        {
            return plus( numberValue.doubleValue() );
        }
        else
        {
            throw new IllegalArgumentException( "Cannot add " + numberValue );
        }
    }
    public NumberValue times( NumberValue numberValue )
    {
        if ( numberValue instanceof IntegralValue )
        {
            return times( numberValue.longValue() );
        }
        else if ( numberValue instanceof FloatingPointValue )
        {
            return times( numberValue.doubleValue() );
        }
        else
        {
            throw new IllegalArgumentException( "Cannot add " + numberValue );
        }
    }
}
